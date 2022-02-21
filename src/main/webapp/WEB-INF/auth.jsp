<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>
        Auth page
    </title>
</head>
<body>

<div id="page">
    <div class="content">
        <div class="login">
            <form action="/login" method="post">
                <table>
                    <tr>
                        <td><label for="username">Login</label></td>
                        <td> <input type='text' id='username' name='username'/></td>
                    </tr>
                    <tr>
                        <td><label for="password">Password</label></td>
                        <td><input type='password' id='password' name='password'/></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <button type="submit">submit</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>