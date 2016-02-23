import subprocess, os
err = open('err.log','a')

def test_valid(filename):
	args1 = ['cat', filename]
	args2 = ['java', 'oncotime.Main']
	p1 = subprocess.Popen(args1, stdout=subprocess.PIPE)
	l=[]
	output = subprocess.check_output(args2, stdin=p1.stdout)
	if output.lower().strip() != 'valid':
		print "Error with " + filename +'   ' + output
		return 1
	return 0

cnt = 0
total = 0
for f in os.listdir('../test'):
	total += 1
	if os.path.isdir('../test/' + f):
		continue
	cnt += test_valid('../test/'+f)
print str(1-(float(cnt)/total))
err.close()