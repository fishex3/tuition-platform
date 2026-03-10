import React, { useState } from 'react';

function CreateTuteeListing() {
  const [subject, setSubject] = useState('');
  const [level, setLevel] = useState('');
  const [rate, setRate] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    const listingData = { subject, level, hourlyRate: rate };

    try {
      // Notice this points to /tutee now!
      const response = await fetch('http://localhost:8080/api/posts/tutee', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(listingData),
      });

      if (response.ok) {
        alert('Success! Student request saved.');
      }
    } catch (error) {
      console.error('Error:', error);
    }
  };

  return (
    <div style={{ padding: '20px', maxWidth: '400px', margin: 'auto', fontFamily: 'sans-serif', backgroundColor: '#eefcf5', borderRadius: '8px' }}>
      <h2>Student: Request a Tutor</h2>
      <form onSubmit={handleSubmit} style={{ display: 'flex', flexDirection: 'column', gap: '15px' }}>
        <label>Subject you need help with:</label>
        <input type="text" value={subject} onChange={(e) => setSubject(e.target.value)} required style={{ padding: '8px' }} />
        
        <label>Your Level:</label>
        <input type="text" value={level} onChange={(e) => setLevel(e.target.value)} required style={{ padding: '8px' }} />
        
        <label>Budget ($/hr):</label>
        <input type="number" value={rate} onChange={(e) => setRate(e.target.value)} required style={{ padding: '8px' }} />
        
        <button type="submit" style={{ padding: '10px', backgroundColor: '#28a745', color: 'white', border: 'none', cursor: 'pointer' }}>
          Post Request
        </button>
      </form>
    </div>
  );
}

export default CreateTuteeListing;

