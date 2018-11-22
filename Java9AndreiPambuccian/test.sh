for i in 1 2 3
do
	echo $PATH | cut d=':' -f$i
done
