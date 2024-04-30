// Call the dataTables jQuery plugin
$(document).ready(async function() {
  await loadUsers();
  $('#users').DataTable();
});

async function loadUsers(){
  const response = await fetch("api/users", {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

  const users = await response.json();

  let html = "";

  for (let user of users) {
    html += "<tr>\n" +
        "      <td>"+user.id+"</td>" +
        "      <td>"+user.name+"</td>" +
        "      <td>"+user.email+"</td>" +
        "      <td>"+user.tel+"</td>" +
        "      <td>" +
        "        <a href='#' onclick='deleteUser("+user.id+")' class='btn btn-danger btn-circle btn-sm'>" +
        "          <i class='fas fa-trash'></i>" +
        "        </a>" +
        "      </td>" +
        "    </tr>";
  }
  document.querySelector("#users tbody").outerHTML = html;
}

async function deleteUser(id){

  if(!confirm("Desea eliminar usuario?")){
    return;
  }

  const response = await fetch("api/user/"+id, {
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

  loadUsers();

}