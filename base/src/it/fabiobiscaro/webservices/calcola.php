<?php
// recupero i due valori e l'operazione
$a = $_GET["a"];
$b = $_GET["b"];
$operazione = $_GET["operazione"];

$esecuzione = '$ris = '.$a.$operazione.$b.";";
//echo $esecuzione;
eval($esecuzione);

echo "<risultato>";
echo $ris;
echo "</risultato>";

?>