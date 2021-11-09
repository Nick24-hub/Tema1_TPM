# Tema TPM 1

Grupa :TPM 1 Tema realizata de:

- Alexandrescu Nicolae
- Vacaru Stefan Robert

# Exercitiul 1

![poza](img\ex1.png)

a) Din desen observam ca secventa este linearizabila.

b) Deoarece am aratat ca este linearizabila,va rezulta ca este si consistent secevntiala deoarece executia are sens.

# Exercitiul 2

a) Generalizarea propusa are o problema la metoda `enq()` si anume ca atunci cand coada e plina si se face o operatie de
`deq()` astfel eliberandu-se un loc in coada, mai multe thread-uri vor trece de instructiunea `while` si vor astepta in
metoda `lock` astfel fiecare va adauga cate un element in coada dar avand in vedere ca este doar un loc liber va aparea
o problema de suprascriere. Analog metoda `deq()` va avea un comportament neasteptat in momentul in care se va apela o
data metoda `enq()` urmata de mai multe apeluri `deq()` deoarece se elimina elemente inexistente in coada goala.

b) Nu va fi suficient sa comparam labelul deoarece se poate intampla ca la doua elemente sa le fie atribuit acelasi
label.Daca am apela `lock(1)` si `lock(2)` atunci vor avea amandoua acelasi label , iar cand facem comparatia ne va iesi
din while asa ca va trebui sa comparam tupla.

c) Pe ramura try in cazul in care avem lock-ul in interiorul ei ,daca am avea o exceptie atunci exista posibilitatea sa
sarim peste lock-ul respectiv si sa ajungem direct pe `finally` si se va face `unlock` inainte de `lock`.