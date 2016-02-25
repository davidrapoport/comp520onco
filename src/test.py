import subprocess, os

os.chdir('../test')
def test_valid(filename):
	args1 = ['cat', filename]
	args2 = ['java', '-cp', '../src', 'oncotime.Main']
	p1 = subprocess.Popen(args1, stdout=subprocess.PIPE)
	l=[]
	output = subprocess.check_output(args2, stdin=p1.stdout)
	if output.lower().strip() != 'valid':
		print "Error with " + filename +'   ' + output
		return 1
	return 0

cnt = 0
total = 0
for f in os.listdir('.'):
	total += 1
	if os.path.isdir(f):
		continue
	cnt += test_valid(f)
print str(1-(float(cnt)/total))
