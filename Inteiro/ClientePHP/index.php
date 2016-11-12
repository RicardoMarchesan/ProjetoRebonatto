<html>
    
    <head>
        
        <title>Consumindo WebService</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/> 
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/jquery.tablesorter.js" type="text/javascript"></script>
        <script type="text/javascript">
            
    //Chama a função tablesorter, plugin do jQuery
            $(function() {		
		$("#mensagens").tablesorter({
                    debug: true
                });
            });	
        //Alerta de exclusão  
        function excluir(id){
	if (confirm("Deseja excluir?"))
		window.location = "http://localhost:9090/ClientePHP/index.php?action=del_id&id="+id;
	};
        //Função do botão
        function abrir(){
            window.location = "http://localhost:9090/ClientePHP/form.php"
        };
            
      	</script>
        
    </head>
    
<body align="center">

<?php
//trata a URL, se possui action e id, executa exclusao, caso contrario trata o GET da lista
if (isset($_GET["action"]) && isset($_GET["id"]) && $_GET["action"] == "del_id") 
{
//Recupera o ID do GET da página    
$iddel = $_GET["id"];
//Inicia a biblioteca cURL do PHP
$curl = curl_init();

curl_setopt_array($curl, array(
  CURLOPT_PORT => "8080", //porta do WS
  CURLOPT_URL => "http://localhost:8080/WebServiceRest/javaws/wsrest". $iddel, //Caminho do WS + string do DELETE, recuperado pelo GET
  CURLOPT_RETURNTRANSFER => true, //Recebe resposta
  CURLOPT_ENCODING => "", //Decodificação
  CURLOPT_MAXREDIRS => 10,
  CURLOPT_TIMEOUT => 30,
  CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
  CURLOPT_CUSTOMREQUEST => "DELETE", //metodo
  CURLOPT_HTTPHEADER => array(
    "cache-control: no-cache",
   ),
));

$response = curl_exec($curl); //recebe a resposta do WS
$err = curl_error($curl); //recebe o erro da classe ou WS

curl_close($curl); //encerra classe

if ($err) {
?>
  <script type="text/javascript"> //apresenta o erro
    alert("<?php echo $err; ?>"); 
    window.location.href = "http://localhost:9090/ClientePHP/index.php"; 
</script >
<?php
} else {    //caso contratio
?>
    
<h1>Belas Mensagens</h1>

<?php
}
?>
    
<script type="text/javascript"> //apresenta a resposta
    alert("<?php echo $response; ?>"); 
    window.location.href = "http://localhost:9090/ClientePHP/index.php"; 
</script> 

<?php
}  
else
{     //Caso não tenha os GETs na URL da pagina, trata o GET da lista do WS
?>

<h1>Clientes</h1>
<table id="mensagens" align="center">
    
    <caption><h2>Lista GET</h2></caption> 
    
<thead>
    <tr>
        <th>Codigo</th>
        <th>Mensagem</th>
        <th>Tipo</th>
        <th></th>
    </tr>
</thead>

<tbody>
    
<?php
  //Inicia a biblioteca cURL do PHP
  $curl = curl_init();
  curl_setopt_array($curl, array(
  CURLOPT_PORT => "8080", //porta do WS
  CURLOPT_URL => "http://localhost:8080/WebServiceRest/javaws/wsrest", //Caminho do WS que vai receber o GET
  CURLOPT_RETURNTRANSFER => true, //Recebe resposta
  CURLOPT_ENCODING => "JSON", //Decodificação
  CURLOPT_MAXREDIRS => 10,
  CURLOPT_TIMEOUT => 30,
  CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
  CURLOPT_CUSTOMREQUEST => "GET", //metodo do servidor
  CURLOPT_HTTPHEADER => array(
    "cache-control: no-cache",
   ),
)); //recebe retorno
$data1 = curl_exec($curl); //Recebe a lista no formato jSon do WS
print $data1;
curl_close($curl); //Encerra a biblioteca
$data = json_decode($data1); //Decodifica o retorno gerado no modelo jSon

//$clientes = $data->cliente; função de selecionar o obejto nao suportada pelo POST do WS
foreach ($data as $c) //cria a classe de tratamento
    {
    //Define as arrays
     $id = $c->codigo;
     $mensagem = $c->mensagem;
     $tipo = $c->tipo;
?>
   
    <tr id="<?php echo $id; /*pubica as informações na tabela>*/?>">   
        <td width="80px"><?php echo $id; ?></td>
        <td width="200px"><?php echo $mensagem; ?></td>
        <td align="right" width="90px"><?php echo $tipo; ?></td>
        <td align="center"> <?php echo "<a href='#' onclick=excluir(\"$id\")";/*chama o script da exclusão, para o id da linha*/?> 
            title= "Excluir <?php echo mensagem; ?>"><img width="15px" height="15px"src="css/lixeira.gif" id="X">
             </a>
        </td>
    </tr>
    
<?php
}//encerra PHP do tratamento da lista
?>
    
</tbody>

<?php
}//encerra PHP else
?>   

    <tr  style="background-color: f1f1f1">
        <td colspan="4" align="center">
            <button type="button" onclick="abrir()" class="botao" style="width: 110px; float: none;" >Cadastrar</button>
        </td>
    </tr>
    
</table>
    
</body>

</html>