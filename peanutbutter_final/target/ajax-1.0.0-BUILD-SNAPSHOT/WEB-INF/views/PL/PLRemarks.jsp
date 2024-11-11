<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> remarks </title>
    <style>
    
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            width: 80%;
            max-width: 800px;
            background: white;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        textarea {
            width: 100%;
            height: 400px;
            border: 1px solid #ddd;
            border-radius: 4px;
            padding: 10px;
            font-size: 16px;
        }
        .buttons {
            text-align: right;
            margin-top: 10px;
        }
        button {
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            background-color: #007bff;
            color: white;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <form method="post" action="">
            <textarea name="note" readonly>
                ${dto != null ? dto.plan_remarks : '비고사항이 없습니다'}
            </textarea>
        </form>
    </div>
</body>
</html>