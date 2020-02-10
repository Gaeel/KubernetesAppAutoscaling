import argparse
import sys

def parse_args():
    parser = argparse.ArgumentParser("A simple tool to get over and under pod usage from Prometheus")
    parser.add_argument("-p", "--prometheus", help="Prometheus server url", required=True, type=str)
    parser.add_argument("-k", "--notlscheck", help="Disable cert check verification", action='store_true')
    parser.add_argument("-q", "--query", help="Prometheus query for the metric", required=True, type=str)
    parser.add_argument("-v", "--value", help="Metric target value", required=True, type=float)
    parser.add_argument("-s", "--start", help="Scenario start", required=True, type=str)
    parser.add_argument("-e", "--end", help="Scenario end", required=True, type=str)

    if len(sys.argv) <= 1:
        parser.print_help()
        sys.exit(-1)

    return parser.parse_args()