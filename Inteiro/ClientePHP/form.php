<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Consumindo WebService</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    <script> //Função do botão
        function abrir(){ //funcao do botao listar
            window.location = "http://localhost:9090/ClientePHP/index.php/"
        };            
    </script>
    </head>

    <form name="postform" id="postform" class="rounded" action="post.php" method="post" enctype="multipart/form-data">
    
    <h2>Formulário POST</h2>
    
    <div class="field">
        <label for="mensagem">Mensagem:</label>
        <input type="text" class="input" id="mensagem" name="mensagem"/>
        <p class="hint">Digite a mensagem</p>
    </div>  
    
    <div class="field">
        <label for="tipo">Tipo:</label>
        <input type="number" step="any" class="input" id="tipo" name="tipo" />
        <p class="hint">Digite o tipo da mensagem</p>
        
    </div>
  
        <input type="submit" value="Enviar" class="botao"/>
        <input type="reset" value="Limpar" class="botao">
        <button type="button" onclick="abrir()" class="botao">Listar</button>
    </form>
</body>
</html>
