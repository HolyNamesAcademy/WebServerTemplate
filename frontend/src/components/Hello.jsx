import { useState } from 'react';

import './Hello.css';

const greetingApi = '/api/greeting';

function Hello() {
  const [greeting, setGreeting] = useState('');
  const [name, setName] = useState('');

  const getGreeting = async () => {
    // Create the request path
    let path = greetingApi;
    if (name) {
      path += `?name=${name}`;
    }

    // Make the request to the Java API
    const response = await fetch(path);

    // Parse the response from a string into json.
    const data = await response.json();

    // Set the greeting value.
    setGreeting(data.greeting);
  };

  const handleChange = (event) => {
    const newName = event.target.value; // what the user typed in
    setName(newName);
  };

  const handleSubmit = (e) => {
    // prevent page from reloading when submitting form.
    e.preventDefault();
    getGreeting();
  };

  return (
    <div className="Hello">
      <form onSubmit={handleSubmit}>
        <input name="Name" value={name} onChange={handleChange} />
        <button type="submit">Submit</button>
      </form>

      <p>{greeting}</p>
    </div>
  );
}

export default Hello;
