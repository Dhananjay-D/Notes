# vector Datatype: ordered of same datatype

branch=c("cs","ec","me","cv","is")
id=c(1,2,3,4,5)

print(branch)
print(id)


# Lists Datatype: ordered collection of objects
name="GIT"
l1=list(branch,id,name)
print(l1)

# accesing elements:
print(l1[[1]][1])

# adding an element:
l1[[1]][6]="ee"
l1[[2]][6]=6


result=c("updated list is: ",l1)
print(result)

