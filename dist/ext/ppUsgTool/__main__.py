from lib.args import parse_args
import atexit
import sys
import requests

def main():
    args = parse_args()
    
    s = requests.session()
    s.verify = False if args.notlscheck else True
    atexit.register(lambda : s.close())

    r = s.get(f'{args.prometheus}/api/v1/query_range?query={args.query}&start={args.start}Z&end={args.end}&step=1s')
    r.raise_for_status()

    over = 0
    under = 0
    total_nonnull = 0
    run_time = 0
    min_tstp = sys.maxsize
    max_tstp = - sys.maxsize

    for pod in r.json()['data']['result']:
        for v in pod['values']:

            # Time bound detection
            if v[0] < min_tstp:
                min_tstp = v[0]
            if v[0] > max_tstp:
                max_tstp = v[0]
            
            
            m = float(v[1]) # Value
            if m > args.value:
                over += (m - args.value)

            elif (m < args.value) and (m != 0) :
                under += (args.value - m)
            
            if m != 0:
                total_nonnull += 1
            
            run_time += 1

    user_time_duration = max_tstp - min_tstp

    print("Average pods running: %.3f"%(run_time /  user_time_duration))
    print("Overusage: %d%%"%(over*100/total_nonnull))
    print("Underusage: %d%%"%(under*100/total_nonnull))

if __name__ == "__main__":
    main()