Write-Host "Commit Message:"

$Message = Read-Host


function  GIT_COMMIT() {
    git checkout front-end
    git pull origin front-end
    git add *
    git commit -m $Message
    git push origin front-end
}

GIT_COMMIT